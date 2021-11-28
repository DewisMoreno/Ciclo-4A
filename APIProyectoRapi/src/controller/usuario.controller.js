const usuarioController = {};
const Usuario = require('../model/usuario.model');

usuarioController.getUsuarios = async (req,res) =>{ 
    try {
        const usuarios = await Usuario.find({});
        if(usuarios === null){
            res.send("No se encontraron usuarios en el sistema");
        }else{
            res.json(usuarios);
        }
    } catch (error) {
        console.error(error);
    }
};
usuarioController.getUsuario = async (req,res) =>{
    try {
        const usuario = await Usuario.findOne({documento:req.params.documento});
        if(usuario === null){
            res.send("No se encontró el usuario en el sistema");
        }else{
            res.json(usuario);
        }
    } catch (error) {
        console.error(error);
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
        res.send('Usuario creado exitosamente');
    } catch (error) {
        console.error(error);
    }
};
usuarioController.editUsuario = async (req,res) =>{
    const usuario = await Usuario.findOne({documento:req.params.documento});
        if(usuario === null){
            res.send("No se encontró el usuario en el sistema");
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
            res.send('Uuario actualizado exitosamente');
        }
};
usuarioController.deleteUsuario = async (req,res) =>{
    try {
        const usuario = await Usuario.findOne({documento:req.params.documento});
        if(usuario === null){
            res.send("No se encontró el usuario en el sistema");
        }else{
            await Usuario.deleteOne(usuario);
            res.send('Usuario eliminado exitosamente');
        }
    } catch (error) {
        console.error(error);
    }
};

module.exports = usuarioController;