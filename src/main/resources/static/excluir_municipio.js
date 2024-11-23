

document.querySelectorAll('.excluir').forEach(function(button) {
    button.addEventListener('click', 
    function() {
        if (confirm('Confirma a exclusão?')) {

            const row = this.closest('tr'); 

            const municipioId = this.dataset.municipioId;
            
          
            fetch(`/municipio/${municipioId}`, {
                method: 'DELETE',
                headers: {
                    'Content-Type': 'application/json'
                },
            })
            .then(response => {
                if (response.ok) {
                  
                    console.log('Municipio excluído com sucesso.');

                    
                    row.remove();
                } else {
                
                    console.error('Municipio sendo usado por um estado..');
                    alert('Municipio sendo usado por um estado..');
                }
            })
            .catch(error => {
                
                console.error('Erro de rede:', error);
                alert('Erro de rede:' + error);
            });
        }
    });
});
