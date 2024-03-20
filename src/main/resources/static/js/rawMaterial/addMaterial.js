const sidebar = document.getElementById("sidebar");
const closeSidebar = document.getElementById("fecharSidebar");
const addForm = document.getElementById("formularioAdicao");
const materialIdInput = document.getElementById("materialId");
const quantityInput = document.getElementById("quantidade");
let materialId;

const addRawMaterial = document.querySelectorAll(".addRawMaterial");
addRawMaterial.forEach(function (button) {
    button.addEventListener("click", function () {
        materialId = button.dataset.materialId;
        materialIdInput.value = materialId;
        carregarDadosParaAdicao(materialId);
        sidebar.style.right = "0";
    });
});

addForm.addEventListener("submit", function(event) {
    event.preventDefault();
    const quantidade = quantityInput.value;
    adicionarMaterial(materialId, quantidade);
    console.log("ID do material:", materialId);
    console.log("Quantidade:", quantidade);
});

closeSidebar.addEventListener("click", function() {
    sidebar.style.right = "-250px";
});

function carregarDadosParaAdicao(materialId) {
    const xhr = new XMLHttpRequest();
    xhr.onload = function () {
        if (xhr.status >= 200 && xhr.status < 300) {
            exibirTelaAdicao(JSON.parse(xhr.responseText));
        } else {
            console.error("Erro ao carregar dados para adição:", xhr.statusText);
        }
    };

    xhr.open("GET", "/add/rawMaterial/" + materialId);
    xhr.setRequestHeader("Content-Type", "application/json");
    xhr.send();
}

function adicionarMaterial(rawMaterialId, quantidade) {
    var formData = new FormData();
    formData.append("id", rawMaterialId);
    formData.append("quantity", quantidade);

    var xhr = new XMLHttpRequest();
    xhr.open("POST", "/add/rawMaterial/" + rawMaterialId);
    // xhr.setRequestHeader("X-CSRF-TOKEN", csrfToken); // Se necessário, configure o token CSRF

    xhr.onload = function() {
        if (xhr.status === 200) {
            console.log("Material adicionado com sucesso:", xhr.response);
        } else {
            console.error("Erro ao adicionar material:", xhr.statusText);
        }
    };

    // Envia a requisição AJAX com os dados do formulário
    xhr.send(formData);
}

function exibirTelaAdicao(data) {
    console.log(data)
}