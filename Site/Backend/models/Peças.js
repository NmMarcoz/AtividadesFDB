const {sequelize, DataTypes} = require('sequelize');

module.exports =(sequelize, DataTypes) =>{
    const Pecas = sequelize.define('Pecas',{
        nome:{
            type: DataTypes.STRING,
            allowNull: false
        },
        tipo:{
            type: DataTypes.STRING,
            allowNull:false,

        },
        preco:{
            type: DataTypes.FLOAT,
            allowNull: false
        },
    });
    return Pecas
}