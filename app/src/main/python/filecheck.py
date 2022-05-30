def main(path):
    try:
        file=open(paths+"/face/data.xml","r")
        file.close()
        return true
    except Exception as e:
        return false
