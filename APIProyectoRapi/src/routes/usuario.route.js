const {Router} = require("express");
const router = Router();

const{getUsuarios, getUsuario, createUsuario, editUsuario, deleteUsuario} = require('../controller/usuario.controller');

router.get('/usuarios', getUsuarios); // pedir todos los usuarios
router.get('/usuario/:documento', getUsuario); // pedir un solo usuario
router.post('/usuario', createUsuario); // Crear un usuario
router.put('/usuario/:documento', editUsuario); // Editar un usuario
router.delete('/usuario/:documento', deleteUsuario); // Eliminar un usuario

module.exports = router;