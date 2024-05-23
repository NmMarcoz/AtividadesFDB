const { Peças } = require("../models");

const findAllPeças = async (req, res) => {
  try {
    console.log("aqui");
    peças = await Peças.findAll();
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
      message: "Erro durante a consulta de dados",
      error: error,
    }); 
  }
};

const findPerName = async (req, res) => {
  try {
    const nome = req.query.nome;
    console.log("aquiiii");
    console.log(nome);
    if (!nome) {
      return res.status(400).send({
        message: "O campo nome é obrigatório",
      });
    }

    const peça = await Peças.findAll({ where: { nome: nome } });
    console.log(peça)
    if (peça.length ===0) {
        return res.status(400).send({
            message: "não existem peças com esse nome"
        })
        
    }

    return res.status(200).send({
      message: "Sucesso!",
      peça: peça,
    });
  } catch (error) {
    res.status(500).send({
      message: "Não foi possível concluir a requisição",
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
    const peça = await Peças.findByPk(id);
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
      message: "Não foi possível concluir a requisição",
      erro: error,
    });
  }
};

const createPeça = async (req, res) => {
  try {
    const request = req.body;
    console.log(req.body);
    //console.log(req.body.tipo)
    console.log(request);
    const { nome, tipo, preço } = request;
    if (!nome || !tipo || !preço) {
      return res
        .status(400)
        .send({ message: "Todos os campos são obrigatórios." });
    }
    await Peças.create(request);
    return res.status(200).send({
      message: "Peça registrada com sucesso!",
      request: request,
    });
  } catch (error) {
    console.error("Erro durante a a criação, erro: ", error);
    return res.status(500).send({
      message: "Erro interno de servidor",
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
    await Peças.destroy({
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
      message: "Erro interno de servidor",
    });
  }
};

module.exports = {
  findAllPeças,
  createPeça,
  findPerName,
  findByPk,
  deleteByPk,
};
