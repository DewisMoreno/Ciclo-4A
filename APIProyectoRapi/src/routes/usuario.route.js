const {Router} = require("express");
const router = Router();
const auth = require('../Auth/Auth');


const{getUsuarios, tokenUsuario, getUsuario, createUsuario, editUsuario, deleteUsuario} = require('../controller/usuario.controller');

router.get('/usuarios', auth, getUsuarios); // pedir todos los usuarios
router.post('/usuario/tokenUsuario', tokenUsuario); // Crear Token
router.get('/usuario/:documento', auth, getUsuario); // pedir un solo usuario
router.post('/usuario', auth, createUsuario); // Crear un usuario
router.put('/usuario/:documento', auth, editUsuario); // Editar un usuario
router.delete('/usuario/:documento', auth, deleteUsuario); // Eliminar un usuario

module.exports = router;