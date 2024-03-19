function calculatePrice() {
    const quantity = parseFloat(document.getElementById('raw-material_quantity').value);
    const unitPrice = parseFloat(document.getElementById('raw-material_price').value);
    const totalPrice = parseFloat(document.getElementById('raw-material_total_price').value);

    if (!isNaN(unitPrice) && !isNaN(quantity)) {
        document.getElementById('raw-material_total_price').value = (unitPrice * quantity).toFixed(2);
    } else if (!isNaN(totalPrice) && !isNaN(quantity) && totalPrice > 0) {
        document.getElementById('raw-material_price').value = (totalPrice / quantity).toFixed(2);
    }
}

document.getElementById('raw-material_quantity').addEventListener('input', calculatePrice);
document.getElementById('raw-material_price').addEventListener('input', function() {
    document.getElementById('raw-material_total_price').value = '';
    calculatePrice();
});

document.getElementById('raw-material_total_price').addEventListener('input', function() {
    document.getElementById('raw-material_price').value = '';
    calculatePrice();
});