'use strict'

var usernamePage = document.querySelector('#username-page')
var chatPage = document.querySelector('#chat-page')
var usernameForm = document.querySelector('#usernameForm')
var messageForm = document.querySelector('#messageForm')
var messageInput = document.querySelector('#message')
var messageArea = document.querySelector('#messageArea')
var userArea = document.querySelector('#userArea')
var metricsArea = document.querySelector('#metricsArea')
var connectingElement = document.querySelector('.connecting')

var baseUrl = window.location.host
var wsUrl = 'ws://' + baseUrl + '/websocket'

var stompClient = new StompJs.Client({
  brokerURL: wsUrl
})
var users = new Set()
stompClient.onConnect = onConnected
stompClient.onWebSocketClose = onError
stompClient.onStompError = onError

var username = null

var colors = [
  '#2196F3',
  '#32c787',
  '#00BCD4',
  '#ff5652',
  '#ffc107',
  '#ff85af',
  '#FF9800',
  '#39bbb0',
  '#fcba03',
  '#fc0303',
  '#de5454',
  '#b9de54',
  '#54ded7',
  '#54ded7',
  '#1358d6',
  '#d611c6'
]

function connect(event) {
  username = document.querySelector('#name').value.trim()
  if (username) {
    usernamePage.classList.add('hidden')
    chatPage.classList.remove('hidden')

    fetch('/rooms')
      .then((e) => e.json())
      .then((rooms) => rooms['public']?.members)
      .then((members) => members.map((e) => handleUser(e, true)))
      .catch((e) => console.error(e))

    triggerMetrics()

    stompClient.activate()
  }
  event.preventDefault()
}

function onConnected() {
  // Subscribe to the Public Topic
  stompClient.subscribe('/topic/public', onMessageReceived)

  // Tell your username to the server
  stompClient.publish({
    destination: '/app/chat.register',
    body: JSON.stringify({ sender: username, roomId: 'public', eventType: 'JOIN' })
  })

  connectingElement.classList.add('hidden')
}

function onError(error) {
  connectingElement.textContent =
    'Could not connect to WebSocket! Please refresh the page and try again or contact your administrator.'
  connectingElement.style.color = 'red'
}

function send(event) {
  var messageContent = messageInput.value.trim()

  if (messageContent && stompClient) {
    var chatMessage = {
      sender: username,
      content: messageInput.value,
      roomId: 'public',
      eventType: 'CHAT'
    }

    stompClient.publish({ destination: '/app/chat.send', body: JSON.stringify(chatMessage) })
    messageInput.value = ''
  }
  event.preventDefault()
}

/**
 * Handles the received message and updates the chat interface accordingly.
 * param {Object} payload - The payload containing the message data.
 */
function onMessageReceived(payload) {
  var message = JSON.parse(payload.body)

  var messageElement = document.createElement('li')

  if (message.eventType === 'JOIN') {
    handleUser(message.sender, true)
    messageElement.classList.add('event-message')
    message.content = message.sender + ' joined!'
  } else if (message.eventType === 'LEAVE') {
    handleUser(message.sender, false)
    messageElement.classList.add('event-message')
    message.content = message.sender + ' left!'
  } else {
    triggerMetrics()
    messageElement.classList.add('chat-message')

    var avatarElement = document.createElement('i')
    var avatarText = document.createTextNode(message.sender[0])
    avatarElement.appendChild(avatarText)
    avatarElement.style['background-color'] = getAvatarColor(message.sender)

    messageElement.appendChild(avatarElement)

    var usernameElement = document.createElement('span')
    var usernameText = document.createTextNode(message.sender)
    usernameElement.appendChild(usernameText)
    messageElement.appendChild(usernameElement)
    // * update
    usernameElement.style['color'] = getAvatarColor(message.sender)
    //* update end
  }

  var textElement = document.createElement('p')
  var messageText = document.createTextNode(message.content)
  textElement.appendChild(messageText)

  messageElement.appendChild(textElement)
  // * update
  if (message.sender === username) {
    // Add a class to float the message to the right
    messageElement.classList.add('own-message')
  } // * update end
  messageArea.appendChild(messageElement)
  messageArea.scrollTop = messageArea.scrollHeight
}

function handleUser(username, isJoin) {
  if (isJoin) {
    if (!users.has(username)) {
      users.add(username)
      createUserElement(username)
    }
  } else {
    if (users.has(username)) {
      users.delete(username)
      var element = document.getElementById('id-' + username)
      element && userArea.removeChild(element)
    }
  }
}

function createUserElement(username) {
  var messageElement = document.createElement('li')
  messageElement.id = 'id-' + username
  messageElement.classList.add('chat-message', 'flex')

  var avatarElement = document.createElement('i')
  var avatarText = document.createTextNode(username[0])
  avatarElement.appendChild(avatarText)
  avatarElement.style['background-color'] = getAvatarColor(username)

  messageElement.appendChild(avatarElement)

  var usernameElement = document.createElement('span')
  var usernameText = document.createTextNode(username)
  usernameElement.appendChild(usernameText)
  messageElement.appendChild(usernameElement)
  usernameElement.style['color'] = getAvatarColor(username)
  userArea.appendChild(messageElement)
}

function getAvatarColor(messageSender) {
  var hash = 0
  for (var i = 0; i < messageSender.length; i++) {
    hash = 31 * hash + messageSender.charCodeAt(i)
  }

  var index = Math.abs(hash % colors.length)
  return colors[index]
}

usernameForm.addEventListener('submit', connect, true)
messageForm.addEventListener('submit', send, true)

var metricsInterval = null
function triggerMetrics() {
  metricsInterval && clearInterval(metricsInterval)

  const fetchData = () => {
    fetch('/metrics')
      .then((e) => e.json())
      .then((metrics) => {
        metricsArea.innerHTML = ''
        Object.entries(metrics)
          .sort()
          .forEach(([key, value]) => {
            var p = document.createElement('p')
            p.style.color = 'white'
            p.innerText = key + ': ' + metrics[key]
            metricsArea.appendChild(p)
          })
      })
      .catch((e) => console.error(e))
  }
  fetchData()
  metricsInterval = setInterval(() => {
    fetchData()
  }, 15000)
}
