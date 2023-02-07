package it.sincon.gepred.documentale.diogene.enums;

public enum TipoDocumento {
	DOCUMENTO{
		@Override
		public String toString(){
			return "Documento";
		}
	},
	DOCUMENTO_FIRMATO_DIGITALMENTE{
		@Override
		public String toString(){
			return "DocumentoFirmatoDigitalmente";
		}
	},
	DOCUMENTO_WEB{
		@Override
		public String toString(){
			return "DocumentoWeb";
		}
	},
	NOTA{
		@Override
		public String toString(){
			return "Nota";
		}
	},
	EMAIL{
		@Override
		public String toString(){
			return "Email";
		}
	},
	POSTA_ELETTRONICA_CERTIFICATA{
		@Override
		public String toString(){
			return "PostaElettronicaCertificata";
		}
	},
	RICEVUTA_PEC{
		@Override
		public String toString(){
			return "RicevutaPEC";
		}
	}


}
