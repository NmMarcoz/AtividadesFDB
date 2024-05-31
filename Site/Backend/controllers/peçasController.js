const { Pecas } = require("../models");
const {Op} = require('sequelize')

const findAllPeças = async (req, res) => {
  try {
    console.log("aqui");
    peças = await Pecas.findAll();
    console.log(peças)
    if (peças.length === 0) {
      return res.status(404).send({
        message: "Sem peças cadastradas",
      });
    }
    return res.status(200).send({
      message: "Requisição com sucesso!",
      peças: peças,
    });
  } catch (error) {
    console.error("Erro durante a consulta nos dados, erro: ", error);
    return res.status(500).send({
      message: "Erro durante a comunicação com o banco",
      error: error,
    }); 
  }
};

const findPerName = async (req, res) => {
  try {
    const nome = req.query.nome;
    if (!nome) {
      return res.status(400).send({
        message: "O campo nome é obrigatório",
      });
    }

    const peças = await Pecas.findAll({ 
      where: 
      { nome:{
        [Op.like]: `%${nome}%`

    }} });
    //return res.status(200).send({peças: peça})
    //console.log(peça)
    if (peças.length ===0) {
        return res.status(400).send({
            message: "não existem peças com esse nome"
       })
        
    }
    return res.status(200).send({
      message: "Sucesso!",
      peça: peças,
    });
  } catch (error) {
    res.status(500).send({
      message: "Erro durante a comunicação com o banco",
      error: error,
    });
  }
};

const findByPk = async (req, res) => {
  try {
    const id = req.params.id;
    console.log(id);
    if (!id) {
      return res.status(400).send({
        message: "O campo ID é obrigatório!",
      });
    }
    const peça = await Pecas.findByPk(id);
    if (!peça) {
      console.log("....");
      return res.status(400).send({
        message: "Não existem peças cadastradas com esse ID",
      });
    }
    return res.status(200).send({
      message: "Sucesso!",
      peça: peça,
    });
  } catch (error) {
    res.status(500).send({  
      message: "Erro durante a comunicação com o banco",
      erro: error,
    });
  }
};

const createPeça = async (req, res) => {
  try {
    const request = req.body;
  
    const { nome, tipo, preco } = request;
    if (!nome || !tipo || !preco) {
      return res
        .status(400)
        .send({ message: "Todos os campos são obrigatórios." });
    }
    await Pecas.create(request);
    return res.status(200).send({
      message: "Peça registrada com sucesso!",
      request: request,
    });
  } catch (error) {
    console.error("Erro durante a a criação, erro: ", error);
    return res.status(500).send({
      message: "Erro durante a comunicação com o banco",
      error: error,
    });
  }
};

const deleteByPk = async (req, res) => {
  try {
    const id = req.params.id;
    if (!id) {
      return res.status(400).send({
        message: "id é obrigatório",
      });
    } 
    await Pecas.destroy({
      where: {
        id: id,
      },
    });
    return res.status(200).send({
      message: "Peça removida com sucesso",
      id: id,
    });
  } catch (error) {
    res.status(500).send({
      message: "Erro durante a comunicação com o banco",
    });
  }
};

const deleteAll = async(req,res)=>{
  try{
    await Pecas.truncate();
    return res.status(200).send({message:"Tabela deletada com sucesso"})
  }catch(error){
    return res.status(500).send({
      message: "Erro durante a comunicação com o banco",
      erro: error
    })
  }
  
}

const updatePerId = async(req,res)=>{
  try{
    const id = req.params.id
    const update = req.body
    if(!update){
      return res.status(400).send({
        message: "insira ao menos um campo"
      })
    }
    const {nome, tipo, preco} = update
    if(!nome && !tipo && preco){
      return res.status(400).send({
        message: "insira pelo menos um campo"
      })
    }
    await Pecas.update(
      { 
        nome: nome,
        tipo: tipo,
        preco: preco
       },
      {
        where: {
          id: id
        },
      },
    )
    const peca = await Pecas.findByPk(id, {
      attributes: ['id', 'nome', 'tipo', 'preco'],
    })

    return res.status(200).send({
      message: "peça alterada com sucesso", 
      peça: peca
    })

  }catch(error){
    return res.status(500).send({
     
      message: "Erro durante a comunicação com o banco"
      
    })
  }
}

module.exports = {
  findAllPeças,
  createPeça,
  findPerName,
  findByPk,
  deleteByPk,
  deleteAll,
  updatePerId
};
