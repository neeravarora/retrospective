function CurrentIterationWhatWentWell(){
my_form=document.createElement('FORM');
my_form.name='myForm';
my_form.method='POST';
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