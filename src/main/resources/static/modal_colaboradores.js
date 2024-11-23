


    // Preencher os campos do modal de visualização com os dados do colaborador
    const visualizarModal = document.getElementById('visualizarColaboradorModal');
    visualizarModal.addEventListener('show.bs.modal', function (event) {
    const button = event.relatedTarget;
    const nome = button.getAttribute('data-nome');
    const email = button.getAttribute('data-email');
    const funcao = button.getAttribute('data-funcao');
    const nascimento = button.getAttribute('data-nascimento');


    document.getElementById('colaboradorNome').textContent = nome;
    document.getElementById('colaboradorEmail').textContent = email;
    document.getElementById('colaboradorFuncao').textContent = funcao;
    document.getElementById('colaboradorNascimento').textContent = nascimento;

});

    // Preencher o iframe de atualização com os dados do colaborador
    const atualizarModal = document.getElementById('atualizarColaboradorModal');
    atualizarModal.addEventListener('show.bs.modal', function (event) {
    const button = event.relatedTarget;
    const id = button.getAttribute('data-id');
    const iframeSrc = `/atualizarColaboradores/${id}`;
    document.getElementById('atualizarIframe').src = iframeSrc;
});

    // Limpar o iframe ao fechar o modal
    document.getElementById('atualizarColaboradorModal').addEventListener('hidden.bs.modal', function () {
    const iframe = document.getElementById('atualizarIframe');
    iframe.src = ''; // Limpa o iframe
});


    // Ouve a mensagem enviada pela página de sucesso no iframe
    window.addEventListener('message', function (event) {
    if (event.data === 'fechar-modal') {
    // Fecha o modal de cadastro
    const cadastrarModal = bootstrap.Modal.getInstance(document.getElementById('cadastrarColaboradorModal'));
    if (cadastrarModal) {
    cadastrarModal.hide(); // Fecha o modal
}

    // Recarrega a página principal para refletir as alterações
    location.reload();
}
});


