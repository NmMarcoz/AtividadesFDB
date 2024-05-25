const express = require('express');
const app = express();
const cors = require('cors');
app.use(express.json());
app.use(cors());

const peçasRouter = require('./routers/peçasRouter')

const db = require('./models');

app.use('/pecas', peçasRouter);
try{
    db.sequelize.sync().then(()=>{
        console.log("Connection ok!")
        app.listen(3001, ()=>{
            console.log("listening on the port 3001")
        })
    });
   
}catch(error){
    console.error("Unnable to connect with the database, error: ", error);
}

