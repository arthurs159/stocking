var selectedRawMaterials = [];

function addSelectedRawMaterial() {
    var rawMaterialSelect = document.getElementById('rawMaterialSelect');
    var quantityInput = document.getElementById('quantityInput');
    var unitSelect = document.getElementById('unitSelect');

    var rawMaterialId = rawMaterialSelect.value;
    var quantity = quantityInput.value;
    var unit = unitSelect.value;
    var materialName = Array.from(rawMaterialSelect.options).find(option => option.value === rawMaterialId).textContent;
    var unitName = Array.from(unitSelect.options).find(option => option.value === unit).textContent;

    if (rawMaterialId && quantity) {
        selectedRawMaterials.push({ rawMaterialId: rawMaterialId, quantity: quantity, materialUnit: unit,
            materialName: materialName, materialUnitName: unitName});
        clearInputFields();
        updateSelectedRawMaterialsList();
        updateHiddenInputs();
    }
}

function clearInputFields() {
    document.getElementById('rawMaterialSelect').value = '';
    document.getElementById('quantityInput').value = '';
}

function updateSelectedRawMaterialsList() {
    var listContainer = document.getElementById('selectedRawMaterials');
    listContainer.innerHTML = '';

    selectedRawMaterials.forEach(function (item, index) {
        var listItem = document.createElement('li');
        listItem.textContent = `${item.quantity}${item.materialUnitName} de ${item.materialName}(s)`

        var deleteButton = document.createElement('button');
        deleteButton.textContent = 'Excluir';
        deleteButton.onclick = function () {
            deleteSelectedRawMaterial(index);
        };

        listItem.appendChild(deleteButton);
        listContainer.appendChild(listItem);
    });
}

function deleteSelectedRawMaterial(index) {
    selectedRawMaterials.splice(index, 1);
    updateSelectedRawMaterialsList();
    updateHiddenInputs();
}

function updateHiddenInputs() {
    var hiddenInputsContainer = document.getElementById('hiddenInputsContainer');
    hiddenInputsContainer.innerHTML = '';

    selectedRawMaterials.forEach(function (item, index) {
        hiddenInputsContainer.appendChild(createHiddenInput('rawMaterialId', index, item.rawMaterialId));
        hiddenInputsContainer.appendChild(createHiddenInput('quantity', index, item.quantity));
        hiddenInputsContainer.appendChild(createHiddenInput('unit', index, item.materialUnit));
    });
}

function createHiddenInput(name, index, value) {
    var input = document.createElement('input');
    input.type = 'hidden';
    input.name = 'rawMaterialQuantities[' + index + '].' + name;
    input.value = value;
    return input;
}