
// Adicione um ouvinte de eventos aos botões de exclusão
document.querySelectorAll('.excluir').forEach(function(button) {
    button.addEventListener('click', 
    function() {
        if (confirm('Confirma a exclusão?')) {

            const row = this.closest('tr'); // Obtém a linha atual da tabela

            const usuarioId = this.dataset.usuarioId;
            

            fetch(`/usuario/${usuarioId}`, {
                method: 'DELETE',
                headers: {
                    'Content-Type': 'application/json'
                },
            })
            .then(response => {
                if (response.ok) {

                    console.log('Usuário excluído com sucesso.');


                    row.remove();
                } else {

                    console.error('Erro ao excluir usuário.');
                    alert('Erro ao excluir usuário');
                }
            })
            .catch(error => {
                console.error('Erro de rede:', error);
                alert('Erro de rede:' + error);
            });
        }
    });
});
