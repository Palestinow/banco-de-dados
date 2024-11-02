document.getElementById('btnadicionar').addEventListener('click', function() {
    const atividadeInput = document.getElementById('atividade');
    const atividade = atividadeInput.value.trim();
    const categoriaSelect = document.querySelector('select[name="select"]');
    const categoria = categoriaSelect.value;

    if (atividade === '') {
        alert('Por favor, adicione uma atividade.');
        return;
    }

    const novoItem = document.createElement('div');
    novoItem.textContent = atividade;
    novoItem.setAttribute('draggable', true);
    novoItem.classList.add('item'); // Classe para estilização

    novoItem.addEventListener('dragstart', dragStart);

    const escaneadoDiv = document.getElementById(`escaneado${categoria.charAt(1)}`);
    escaneadoDiv.appendChild(novoItem);

    atividadeInput.value = '';
});

// Funções de arrastar
function dragStart(e) {
    e.dataTransfer.setData('text/plain', e.target.textContent);
    e.target.classList.add('dragging');
}

// Permite soltar os itens
document.querySelectorAll('.escaneado1, .escaneado2, .escaneado3, .escaneado4').forEach(container => {
    container.addEventListener('dragover', e => e.preventDefault()); // Permite que o item seja solto
    container.addEventListener('drop', drop);
});

function drop(e) {
    e.preventDefault();
    const atividade = e.dataTransfer.getData('text/plain');
    const novoItem = document.createElement('div');
    novoItem.textContent = atividade;
    novoItem.setAttribute('draggable', true);
    novoItem.classList.add('item');

    novoItem.addEventListener('dragstart', dragStart);
    e.target.appendChild(novoItem);
}
