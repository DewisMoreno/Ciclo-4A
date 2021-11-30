const usuarioController = {};
const Usuario = require('../model/usuario.model');

usuarioController.getUsuarios = async (req,res) =>{ 
    try {
        const usuarios = await Usuario.find({});
        if(Object.entries(usuarios).length === 0){
            res.status(200).send("No se encontraron usuarios en el sistema");
        }else{
            res.status(200).json(usuarios);
        }
    } catch (error) {
        console.log(error);
        res.status(500).send("Ocurrió un error al consultar los usuarios");
    }
};
usuarioController.getUsuario = async (req,res) =>{
    try {
        const usuario = await Usuario.findOne({documento:req.params.documento});
        if(usuario === null){
            res.status(200).send("No se encontró el usuario en el sistema");
        }else{
            res.status(200).json(usuario);
        }
    } catch (error) {
        console.log(error);
        res.status(500).send("Ocurrió un error al consultar el usuario");
    }
};
usuarioController.createUsuario = async (req,res) =>{
    try {
        const usuarioTemp = {
            documento: req.body.documento,
            nombre: req.body.nombre,
            apellido: req.body.apellido,
            telefono: req.body.telefono,
            direcciones: req.body.direcciones,
            correo: req.body.correo,
            clave: req.body.clave,
            token: ""
        };
        let createUsuario = new Usuario(usuarioTemp);
        await createUsuario.save();
        res.status(201).send('Usuario creado exitosamente');
    } catch (error) {
        console.log(error);
        res.status(500).send("Ocurrió un error al crear el usuario");
    }
};
usuarioController.editUsuario = async (req,res) =>{
    try{
        const usuario = await Usuario.findOne({documento:req.params.documento});
        if(usuario === null){
            res.status(200).send("No se encontró el usuario en el sistema");
        }else{
            const usuarioTemp = {
                documento: req.body.documento,
                nombre: req.body.nombre,
                apellido: req.body.apellido,
                telefono: req.body.telefono,
                direcciones: req.body.direcciones,
                correo: req.body.correo,
                clave: req.body.clave
            };
            await Usuario.updateOne({documento: req.params.documento},usuarioTemp);
            res.status(201).send('Uuario actualizado exitosamente');
        }
    } catch (error) {
        console.log(error);
        res.status(500).send("Ocurrió un error al editar el usuario");
    }
};
usuarioController.deleteUsuario = async (req,res) =>{
    try {
        const usuario = await Usuario.findOne({documento:req.params.documento});
        if(usuario === null){
            res.status(200).send("No se encontró el usuario en el sistema");
        }else{
            await Usuario.deleteOne(usuario);
            res.status(200).send('Usuario eliminado exitosamente');
        }
    } catch (error) {
        console.log(error);
        res.status(500).send("Ocurrió un error al eliminar el usuario");
    }
};

module.exports = usuarioController;