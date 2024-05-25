const {Adm} = require('../models')

const create = async(req,res) =>{
    try{
        const adm = req.body
        const{nome, senha} = adm
        if(!nome || !senha){
            return res.status(400).send({
                message: "Todos os campos são obrigatórios"
            })
        }
        await Adm.create(adm)
        return res.status(200).send({
            message: "usuário criado com sucesso!",
            usuario: adm
        })
    }catch(error){
        return res.status(500).send({
            message: "erro criando o usuário",
            erro: error
        })
    }
    
}
const auth = async(req, res) =>{
    try{
        const adm = req.body;
        const {nome, senha} = adm;
        if(!nome || !senha){
            return res.status(400).send({
                message: "todos os campos são obrigatórios"
            })
        }
        const userAdm = await Adm.findOne({where:{
            nome: nome,
            senha: senha
        }})
        if(!userAdm){
            return res.status(404).send({
                message: "autenticação negada."
            })
        }
        return res.status(200).send({
            message: "autenticação aferida."      
        })
    }catch(error){
        res.status(500).send({
            message: "erro durante a autenticação",
            erro: error
        })
    }
    
}

module.exports ={
    create,
    auth
}