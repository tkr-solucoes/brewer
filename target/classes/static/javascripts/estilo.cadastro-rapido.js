$(function () {
	
	var modal = $('#modalCadastroRapidoEstilo');	
	var botaoSalvar = modal.find('.js-modal-cadastro-estilo-salvar-btn');
	var form = modal.find('form');
	form.on('submit' , function(event) { event.preventDefault() } );
	var url = form.attr('action');
	var inputNomeEstilo = $('#nomeEstilo');
	var containerMessagemErro = $('.js-menssagem-cadastro-rapido-estilo');
	
	modal.on('shown.bs.modal' , onModalShow);
	modal.on('hide.bs.modal' , onModalClose);
	botaoSalvar.on('click', onBotaoSalvarClick);
	
	function onModalShow(){
		
		inputNomeEstilo.focus();
		
	}
	
	function onModalClose(){
		
		inputNomeEstilo.val('');
		containerMessagemErro.addClass('hidden');
		form.find('.form-group').removeClass('has-error');
	}
	
	function onBotaoSalvarClick(){
		
		var nomeEstilo = inputNomeEstilo.val().trim();
		$.ajax({
			
			url : url,
			method : 'POST',
			contentType: 'application/json',
			data: JSON.stringify({nome: nomeEstilo}),
			error: onErroSalvandoEstilo,
			success: onEstiloSalvo
			
		});
	}
	
	function onErroSalvandoEstilo(obj){
		
		var menssagemErro =  obj.responseText;
		containerMessagemErro.removeClass('hidden');
		containerMessagemErro.html('<span>' + menssagemErro + '</span>');
		form.find('.form-group').addClass('has-error');
	}
	
	function onEstiloSalvo(estilo){
		
		var comboEstilo = $('#estilo');
		comboEstilo.append('<option value=' + estilo.codigo + '>' + estilo.nome+ '</option>');
		comboEstilo.val(estilo.codigo);
		modal.modal('hide');
		
	}
	
	 
});