import random

print('Bem vindo ao gerador de senhas!')
print('-'*31)
caracteres = ('abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ!@#$%&*,.;:?0123456789')

numeroSenhas = int(input('Quantas senhas deseja criar? '))
lengthPwd = int(input('Qual o tamanho da senha: '))

print('\nAqui estão suas senhas: ')

#Gera quantas senhas foram solicitadas
for pwd in range(numeroSenhas):
    passwords = ''
#Embaralha os caracteres de acordo com o tamanho escolhido
    for i in range(lengthPwd):
        passwords += random.choice(caracteres)
    print(passwords)