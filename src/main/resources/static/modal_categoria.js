const visualizarModal = document.getElementById('visualizarCategoriaModal');
if (visualizarModal) {
    visualizarModal.addEventListener('show.bs.modal', function (event) {
        const button = event.relatedTarget;
        const nome = button.getAttribute('data-nome');

        // Atualiza os campos no modal
        document.getElementById('categoriaNome').textContent = nome;
    });
} else {
    console.error("Elemento 'visualizarCategoriaModal' não encontrado.");
}

const atualizarModal = document.getElementById('atualizarCategoriaModal');
if (atualizarModal) {
    atualizarModal.addEventListener('show.bs.modal', function (event) {
        const button = event.relatedTarget;
        const id = button.getAttribute('data-id');
        const iframeSrc = `/atualizarcategoria/${id}`;
        document.getElementById('atualizarIframe').src = iframeSrc;
    });

    // Limpar o iframe ao fechar o modal
    atualizarModal.addEventListener('hidden.bs.modal', function () {
        const iframe = document.getElementById('atualizarIframe');
        if (iframe) iframe.src = ''; // Limpa o iframe
    });
} else {
    console.error("Elemento 'atualizarCategoriaModal' não encontrado.");
}

// Ouve a mensagem enviada pela página de sucesso no iframe
window.addEventListener('message', function (event) {
    if (event.data === 'fechar-modal') {
        const cadastrarModal = bootstrap.Modal.getInstance(document.getElementById('cadastrarCategoriaModal'));
        if (cadastrarModal) {
            cadastrarModal.hide(); // Fecha o modal
        }
        location.reload(); // Atualiza a página
    }
});
