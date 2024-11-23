
    // Preencher os campos do modal de visualização com os dados do usuário
    const visualizarModal = document.getElementById('visualizarUsuarioModal');
    visualizarModal.addEventListener('show.bs.modal', function (event) {
    const button = event.relatedTarget;
    const nome = button.getAttribute('data-nome');
    const email = button.getAttribute('data-email');

    document.getElementById('usuarioNome').textContent = nome;
    document.getElementById('usuarioEmail').textContent = email;
});




    // Preencher o iframe de atualização
    const atualizarModal = document.getElementById('atualizarUsuarioModal');
    atualizarModal.addEventListener('show.bs.modal', function (event) {
    const button = event.relatedTarget;
    const id = button.getAttribute('data-id');
    document.getElementById('atualizarIframe').src = `/atualizarusuario/${id}`;
});

    // Limpar o iframe ao fechar o modal de atualização
    document.getElementById('atualizarUsuarioModal').addEventListener('hidden.bs.modal', function () {
    const iframe = document.getElementById('atualizarIframe');
    iframe.src = '';
});

    // Ouve a mensagem enviada pela página de sucesso no iframe
    window.addEventListener('message', function (event) {
    if (event.data === 'fechar-modal') {
    // Fecha o modal de cadastro
    const cadastrarModal = bootstrap.Modal.getInstance(document.getElementById('cadastrarUsuarioModal'));
    if (cadastrarModal) {
    cadastrarModal.hide(); // Fecha o modal
}

    // Recarrega a página principal para refletir as alterações
    location.reload();
}
});
