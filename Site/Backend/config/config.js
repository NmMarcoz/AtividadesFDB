require('dotenv').config()

module.exports = {
  development: {
    username: "root",
    password: process.env.NODE_ENV,
    database: "oficina",
    host: "127.0.0.1",
    dialect: "mysql",
  },
  test: {
    username: "root",
    password: "password",
    database: "oficina",
    host: "127.0.0.1",
    dialect: "mysql",
  },
  production: {
    username: "root",
    password: "password",
    database: "oficina",
    host: "127.0.0.1",
    dialect: "mysql",
  },
};
