const sidebar = document.getElementById("sidebar");
const closeSidebar = document.getElementById("fecharSidebar");
const addForm = document.getElementById("formularioAdicao");
const quantityInput = document.getElementById("quantidade");
const nameInput = document.getElementById("name");
const unitInput = document.getElementById("unidades");
const addRawMaterial = document.querySelectorAll(".addRawMaterial");
let materialId;

addRawMaterial.forEach(function (button) {
    button.addEventListener("click", function () {
        materialId = button.dataset.materialId;
        const materialUnit = button.closest('tr').querySelector('td:nth-child(5)').dataset.materialUnit
        getCompatibleUnits(materialUnit)
        nameInput.value = button.closest('tr').querySelector('td:nth-child(2)').textContent.trim();
        sidebar.style.right = "0";
    });
});

addForm.addEventListener("submit", function(event) {
    event.preventDefault();
    adicionarMaterial(materialId, quantityInput.value, unitInput.value);
});

closeSidebar.addEventListener("click", function() {
    sidebar.style.right = "-250px";
});

function getCompatibleUnits(compatibleUnit) {
    const xhr = new XMLHttpRequest();
    xhr.onload = function () {
        if (xhr.status >= 200 && xhr.status < 300) {
            const unidadesCompativeis = JSON.parse(xhr.responseText);
            const selectUnidades = document.getElementById('unidades');
            selectUnidades.innerHTML = '';
            unidadesCompativeis.forEach(function(unidade) {
                const option = document.createElement('option');
                option.value = unidade;
                option.textContent = unidade;
                selectUnidades.appendChild(option);
            });
        } else {
            console.error("Erro ao carregar dados para adição:", xhr.statusText);
        }
    };

    xhr.open("GET", "/compatible/units?unit=" + compatibleUnit); // Adicionando o parâmetro 'unit' à URL
    xhr.setRequestHeader("Content-Type", "application/json");
    xhr.send();
}

function adicionarMaterial(rawMaterialId, quantidade, unit) {
    var formData = new FormData();
    formData.append("id", rawMaterialId);
    formData.append("quantity", quantidade);
    formData.append("unit", unit);
    console.log(formData);

    var xhr = new XMLHttpRequest();
    xhr.open("POST", "/add/rawMaterial/" + rawMaterialId);

    xhr.onload = function() {
        if (xhr.status === 200) {
            console.log("Material adicionado com sucesso:", xhr.response);
        } else {
            console.error("Erro ao adicionar material:", xhr.statusText);
        }
    };

    xhr.send(formData);
}