//= require fui/fui
//= require_tree admin
$(".submit-form").click(function() {
    $(this).closest("form").submit()
});

$(".links a.icon-delete").click(function() {
    return confirm("Вы уверены?")
});

$(".ui-sortable").sortable({ cursor: 'move', update: function () {
    var order = $(this).sortable("serialize");
    var link = $(this).attr('data-link');
    $.post(link, order);
}});
