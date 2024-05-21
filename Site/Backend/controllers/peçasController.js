const {Peças} = require('../models');

const findAllPeças = async(req,res) =>{
    try{
        peças = await Peças.findAll();
        if(!peças){
            return res.status(404).send({
                message: "Sem peças cadastradas"
            })
        }
        return res.status(200).send({
            message: "Requisição com sucesso!",
            peças: peças
        })
    }catch(error){
        console.error("Erro durante a consulta nos dados, erro: ", error);
        return res.status(500).send({
            message: "Erro durante a consulta de dados",
            error: error
        })
     
    }
}

const createPeça = async(req, res) =>{
    try{
        const request = req.body
        console.log(req.body)
        //console.log(req.body.tipo)
        console.log(request)
        const {nome, tipo, preço} = request
        if(!nome || !tipo ||  !preço){
            return res.status(400).send({message: "Todos os campos são obrigatórios."})
        }
        await Peças.create(request);
        return res.status(200).send({
            message: "Peça registrada com sucesso!",
            request: request
        })
        

    }catch(error){
        console.error("Erro durante a a criação, erro: ", error);
        return res.status(500).send({
            message: "Erro interno de servidor",
            error: error
        
        })
        
    }
}

module.exports ={
    findAllPeças,
    createPeça
}