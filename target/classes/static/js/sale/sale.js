var saleItems = [];

document.querySelector('#addProduct').addEventListener('click', () => {
    var productSelect = document.getElementById("productSelect");
    var productId = productSelect.value;
    console.log("Product : " + productId);
    var productName = productSelect.options[productSelect.selectedIndex].text;
    var productQuantity = document.getElementById("productQuantity").value;
    addSaleItem(productId, productName, productQuantity, true);
});

document.querySelector('#addRawMaterial').addEventListener('click', () => {
    var rawMaterialSelect = document.getElementById("rawMaterialSelect");
    var rawMaterialId = rawMaterialSelect.value;
    console.log("Material : " + rawMaterialId);
    var rawMaterialName = rawMaterialSelect.options[rawMaterialSelect.selectedIndex].text;
    var rawMaterialQuantity = document.getElementById("rawMaterialQuantity").value;
    addSaleItem(rawMaterialId, rawMaterialName, rawMaterialQuantity, false);
});

function addSaleItem(itemId, itemName, quantity, isProduct) {
    var saleItem = {
        id: null,
        sale: null,
        itemType: isProduct ? 'PRODUCT' : 'RAW_MATERIAL',
        itemId: itemId,
        name: itemName,
        quantity: quantity
    };

    saleItems.push(saleItem);
    updateDisplay();
    updateHiddenInput();
}

function updateDisplay() {
    var displayDiv = document.getElementById("selectedItems");
    displayDiv.innerHTML = "";

    var ul = document.createElement("ul");
    saleItems.forEach(function (saleItem) {
        var li = document.createElement("li");
        li.appendChild(document.createTextNode(
            saleItem.itemType === 'PRODUCT'
                ? 'Product: ' + saleItem.name + ', Quantity: ' + saleItem.quantity
                : 'Raw Material: ' + saleItem.name + ', Quantity: ' + saleItem.quantity
        ));
        ul.appendChild(li);
    });

    displayDiv.appendChild(ul);
}


function updateHiddenInput() {
    var saleItemsJson = JSON.stringify(saleItems);
    var hiddenInput = document.getElementById("saleItemsInput");
    hiddenInput.value = saleItemsJson;

}

document.querySelector('#save-button').addEventListener('click', () => {
    var totalPrice = document.getElementById("sale_name").value;
    var paymentMethod = document.getElementById("product_unit").value;

    var saleForm = {
        id: null,
        totalPrice: totalPrice,
        paymentMethod: paymentMethod,
        saleItems: saleItems
    };

    fetch('/sales/create', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(saleForm),
    })
})