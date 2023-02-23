
const proxy_config = [{
    context: ['/**'],
    target: 'http://localhost:8080',
    secure: false,
    "logLevel": "debug"
}]

module.exports = proxy_config;