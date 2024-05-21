const {sequelize, DataTypes} = require('sequelize');

module.exports =(sequelize, DataTypes) =>{
    const Peças = sequelize.define('Peças',{
        nome:{
            type: DataTypes.STRING,
            allowNull: false
        },
        tipo:{
            type: DataTypes.STRING,
            allowNull:false,

        },
        preço:{
            type: DataTypes.FLOAT,
            allowNull: false
        },
    });
    return Peças
}