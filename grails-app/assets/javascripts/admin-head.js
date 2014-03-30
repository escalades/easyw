//= require jquery
//= require jquery.treeview/jquery.treeview
//= require jquery.formstyler/jquery.formstyler
//= require_self

$(document).ready(function(){
    $('.admin-tooltip').popover();
});

(function($){
    $(function(){
        $('input[type=file]').styler({
            browseText: 'Выбрать'});
    })
})(jQuery)

$(function() {
    $( ".datepicker" ).datepicker({
            dateFormat: 'dd.mm.yy'
        }
    );
});