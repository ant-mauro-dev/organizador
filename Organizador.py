import os
import shutil

pasta = os.path.expanduser('~/Downloads')
arquivos = os.listdir(pasta)

print(arquivos)

categorias = {
    ".pdf": "PDFs",

    ".png": "Imagens", 
    ".jpg": "Imagens", 
    ".jpeg": "Imagens", 

    ".zip": "Compactados", 
    ".rar": "Compactados", 

    ".exe": "Instaladores", 
    ".dmg": "Instaladores",

    ".mp3" : "Audios",
    ".wav" : "Audios",
    ".ogg" : "Audios",

    ".aseprite": "Sprite",
    ".gpl" : "Sprite/Paleta"
}

def organizar_pasta(local):

    arquivos = os.listdir(local)

    for arquivo in arquivos:

        caminho = os.path.join(local, arquivo)

        # Se for uma pasta, ignora
        if not os.path.isfile(caminho):
            continue

        nome, extensao = os.path.splitext(arquivo)

        categoria = categorias.get(extensao.lower(), "Outros")

        destino = os.path.join(pasta, categoria)

        os.makedirs(destino, exist_ok=True)

        shutil.move(caminho, os.path.join(destino, arquivo))

organizar_pasta(pasta)


# Organiza os arquivos que estavam dentro de Outros
pasta_outros = os.path.join(pasta, "Outros")

if os.path.exists(pasta_outros):
    organizar_pasta(pasta_outros)


print("Arquivos organizados com sucesso!")