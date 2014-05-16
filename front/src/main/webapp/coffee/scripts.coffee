init = ->
    console.log 'start!'


    $('.js-open-filters, .js-close-filters').click ->
        $('.js-filters-listing').toggle()
        return false


    $('.js-main-container-overlay').click ->
        $('.activate-menu').attr 'checked', false


    return

$ ->
    $('.js-date-from, .js-date-to').pickadate({
        today: ''
        format: 'dd mmm yy'
        max: 'true'
    })



$(document).on 'ready', init