$(document).ready(function() {
    $('#table').DataTable( {
        "processing": true,
        "serverSide": true,
        "ajax": {
            "url": "/fur",
            "type": "GET"
          },
        "columns": [
            { "data": "id" },
            { "data": "gender" },
            { "data": "color" },
            { "data": "price" },
            { "data": "amount" },
            { "data": "date" },
            { "data": "note" }
        ]
    } );
    /*
    $.ajax({
        type: 'GET',
        url: "/fur",
        success: function(res){
            console.log(res);
            $.each(res, function(index, fur) {
                var template = $("#infoTemplate").html();

                $("#table tbody").append(template
                    .replace("{{Id}}", fur.id)
                    .replace("{{Closed}}", report.closed == undefined ? 0 : report.closed)
                    .replace("{{Moved}}", report.moved == undefined ? 0 : report.moved)
                    .replace("{{Hours}}", report.wrongHours == undefined ? 0 : report.wrongHours)
                    .replace("{{Photo}}", report.photo == undefined ? 0 : report.photo)
                    .replace("{{Category}}", report.wrongCategory == undefined ? 0 : report.wrongCategory)
                    .replace("{{Contact Number}}", report.wrongContactNumber == undefined ? 0 : report.wrongContactNumber)
                    .replace("{{Website}}", report.wrongWebsite == undefined ? 0 : report.wrongWebsite)
                    .replace("{{Other}}", report.other == undefined ? "" : report.other.join("<p>*******************************</p>"))
                    .replace("{{color}}", report.existenceStatus == "DELETED" ? "red" : "black"));



            });
        }
    });*/
});