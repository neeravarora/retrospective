$(function() {

	// Get the form.
	var form = $('#CurrentIterationWhatWentWell');

	// Get the messages div.
	var formMessages = $('#form-messages');

	// Set up an event listener for the contact form.
	$(form).submit(function(e) {
		// Stop the browser from submitting the form.
		e.preventDefault();

		// Serialize the form data.
		var formData = $(form).serialize();

		// Submit the form using AJAX.
		$.ajax({
			type: 'POST',
			url: $(form).attr('action'),
			data: formData
		})
		.done(function(response) {
			// Make sure that the formMessages div has the 'success' class.
			$(formMessages).removeClass('error');
			$(formMessages).addClass('success');

			// Set the message text.
			$(formMessages).text(response);

			// Clear the form.
			$('#name').val('');
			$('#email').val('');
			$('#message').val('');
		})
		.fail(function(data) {
			// Make sure that the formMessages div has the 'error' class.
			$(formMessages).removeClass('success');
			$(formMessages).addClass('error');

			// Set the message text.
			if (data.responseText !== '') {
				$(formMessages).text(data.responseText);
			} else {
				$(formMessages).text('Oops! An error occured and your message could not be sent.');
			}
		});

	});

});

function CurrentIterationWhatWentWell(){
my_form=document.createElement('FORM');
my_form.name='myForm';
my_form.method='GET';
my_form.action='CurrentIterationWhatWentWell';

/*my_tb=document.createElement('INPUT');
my_tb.type='HIDDEN';
my_tb.name='username';
my_tb.value=' ';
my_form.appendChild(my_tb);

my_tb=document.createElement('INPUT');
my_tb.type='HIDDEN';
my_tb.name='password';
my_tb.value='Values of my hidden1';
my_form.appendChild(my_tb);*/
document.body.appendChild(my_form);
my_form.submit();
}