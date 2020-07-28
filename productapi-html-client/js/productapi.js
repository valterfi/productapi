$(document).ready(function(){
    
	// Activate tooltip
    $('[data-toggle="tooltip"]').tooltip();

    let baseUrl = 'http:/localhost:8080/'

    updateTable();

    function updateTable() {

        $.getJSON(baseUrl + 'products', function(data) {

            $.each(data, function( index, element ) {
                let id = element.id;
                let name = element.name;
                let price = element.price;
                $('.table tr:last').after('<tr><td>' + id +'</td><td>' + name +  '</td><td>' + price + '</td><td><a href="#editProductModal" class="edit" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a> <a href="#deleteProductModal" class="delete" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a> </td> </tr>');
            });
    
        });

    }

    $('#editProductModal').on('show.bs.modal', function (event) {
        let a = $(event.relatedTarget);
        let row = a.parent().parent();

        let id = row.find("td:eq(0)").text();
        let name = row.find("td:eq(1)").text();
        let price = row.find("td:eq(2)").text();

        let modalBody = $('#editProductModal .modal-body');

        modalBody.find('input[name=id-disabled]').val(id);
        modalBody.find('input[name=id]').val(id);
        modalBody.find('input[name=name]').val(name);
        modalBody.find('input[name=price]').val(price);

    })

    $('#addProductModal form').submit(function() {

        let product = $(this).serializeArray().reduce(function(obj, item) {
            obj[item.name] = item.value;
            return obj;
        }, {});

        $.ajax({
            url: baseUrl + 'products',
            method: 'POST',
            data: JSON.stringify(product),
            contentType: "application/json"
        });

    });

    $('#editProductModal form').submit(function() {

        let product = $(this).serializeArray().reduce(function(obj, item) {
            obj[item.name] = item.value;
            return obj;
        }, {});

        $.ajax({
            url: baseUrl + 'products/' + product.id,
            method: 'PUT',
            data: JSON.stringify(product),
            contentType: "application/json"
        });

    });

    $('#deleteProductModal').on('show.bs.modal', function (event) {
        let a = $(event.relatedTarget);
        let row = a.parent().parent();

        let id = row.find("td:eq(0)").text();

        $('#deleteProductModal .modal-body p span').text(id);
      
    })

    $('#deleteProductModal form').submit(function() {

        let id =  $('#deleteProductModal .modal-body p span').text();

        $.ajax({
            url: baseUrl + 'products/' + id,
            method: 'DELETE',
            contentType: "application/json"
        });

    });

});