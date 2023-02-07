package it.sincon.gepred.documentale.mock;

import java.util.ArrayList;

import it.sincon.gepred.documentale.bean.DocFile;
import it.sincon.gepred.documentale.bean.DocInfo;
import it.sincon.gepred.documentale.bean.DocumentaleException;
import it.sincon.gepred.documentale.service.DocumentaleService;

public class DocumentaleServiceMockImpl implements DocumentaleService {

	public String creaContenitore(String destPath, String regex, String oggettoPratica)
			throws DocumentaleException {
		// TODO Auto-generated method stub
		return "uuid";
	}

	public String ricercaContenitore(String destPath, String regex)
			throws DocumentaleException {
		// TODO Auto-generated method stub
		return "uuid";
	}

	public DocInfo uploadFile(DocInfo file, String uuidContenitore)
			throws DocumentaleException {
		// TODO Auto-generated method stub
		return new DocInfo();
	}

	public Boolean consenteEliminaFile() {
		// TODO Auto-generated method stub
		return false;
	}

	public void eliminaFile(String uuid) throws DocumentaleException {
		// TODO Auto-generated method stub

	}

	public void eliminaDirectory(String uuid) throws DocumentaleException {
		// TODO Auto-generated method stub

	}

	public DocInfo getMetadatiDocumento(String uuid)
			throws DocumentaleException {
		// TODO Auto-generated method stub
		return new DocInfo();
	}

	public DocFile download(String uuidContenitore, String uuidFile)
			throws DocumentaleException {
		// TODO Auto-generated method stub
		return new DocFile();
	}

	public void spostaDocumento(String uuidDocumento, String uuidDestContenitore)
			throws DocumentaleException {
		// TODO Auto-generated method stub

	}

	public ArrayList<DocInfo> documentiContenuti(String uuidContenitore)
			throws DocumentaleException {
		// TODO Auto-generated method stub
		ArrayList<DocInfo> result = new ArrayList<DocInfo>();
		
		DocFile mockFile = new DocFile();
		mockFile.setNome("mockFile");
		mockFile.setUuid("uuid-1");
		
		DocInfo mockDocInfo = new DocInfo();
		mockDocInfo.setFile(mockFile);
		mockDocInfo.setNote("nome mock");
		mockDocInfo.setTitolo("Mock Titolo");
		mockDocInfo.setUuid("uuid-1");
		
		result.add(mockDocInfo);
		return result;
	}

	public String ricercaInContenitore(String searchText, boolean searchForfolder, String uuidPadre) throws DocumentaleException {
		// TODO Auto-generated method stub
		return null;
	}

}
