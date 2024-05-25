const {sequelize, DataTypes} = require('sequelize');

module.exports =(sequelize, DataTypes) =>{
    const Adm = sequelize.define('Adm',{
        nome:{
            type: DataTypes.STRING,
            allowNull: false
        },
       senha:{
            type: DataTypes.STRING,
            allowNull: false
       }
    });
    return Adm
}