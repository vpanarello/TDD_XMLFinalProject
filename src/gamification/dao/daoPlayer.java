/**
 * 
 */
package gamification.dao;
import java.io.IOException;
import java.util.List;

import org.jdom2.Element;
import org.jdom2.JDOMException;
import gamification.entity.Player;

/**
 * S04.02_TDD_ProjetoFinal / daoPlayer.java
 * FIAP / RM30222 - Vagner Panarello
 */
public class daoPlayer {

	XmlAccess xml;

	public daoPlayer() {
		super();
		try {
			xml = new XmlAccess("game.xml");

		} catch (IOException e) {
			e.printStackTrace();
		} catch (JDOMException e) {
			e.printStackTrace();
		}

	}

	public Player recover(String _player){ 

		Element player = null;
		for( Element p : xml.getXmlStruct().getChild("players").getChildren()){
			if(p.getChild("name").getText().equals(_player)){	
				player = p;
				break;
			}
		}
		return getEntity(player);
	}

	public List<Player> recoverAll(){
		List<Player> players =  new ArrayList<>();

		for( Element p : xml.getXmlStruct().getChild("players").getChildren()){
			if(p.getChild("name").getText() != null){	
				players.add(getEntity(p));
			}
		}
		return players;
	}

	private Player getEntity(Element player) {
		Player nPlayer = new Player();

		if (player != null) {
			nPlayer.setName(player.getChild("name").getText());
			nPlayer.setMoedas(Integer.parseInt(player.getChild("score").getChild("moeda").getText()));
			nPlayer.setEstrelas(Integer.parseInt(player.getChild("score").getChild("estrela").getText()));
			nPlayer.setTopicos(Integer.parseInt(player.getChild("score").getChild("topico").getText()));
			nPlayer.setComentarios(Integer.parseInt(player.getChild("score").getChild("comentario").getText()));
			nPlayer.setCurtidas(Integer.parseInt(player.getChild("score").getChild("curtida").getText()));
		}
		return nPlayer;
	}


	public void store(Player player) throws IOException, JDOMException{

		Element xmlInstance = null;

		for(Element p : xml.getXmlStruct().getChild("players").getChildren()){
			
			if(p.getChildText("name").equals(player.getName())){
				xmlInstance = p;
				break;
				}
			}

			if(xmlInstance == null){
				Element newRecord = new Element("player");
				xml.getXmlStruct().getChild("players").addContent(newRecord);
				
				newRecord.addContent(new Element("name").setText(player.getName()));
				
				Element newScores = new Element("score");
				newRecord.addContent(newScores);
				
				newScores.addContent(new Element("moeda").setText(String.valueOf(player.getMoedas())));
				newScores.addContent(new Element("estrela").setText(String.valueOf(player.getEstrelas())));
				newScores.addContent(new Element("topico").setText(String.valueOf(player.getTopicos())));
				newScores.addContent(new Element("comentario").setText(String.valueOf(player.getComentarios())));
				newScores.addContent(new Element("curtida").setText(String.valueOf(player.getCurtidas())));
				
			} else {
				xmlInstance.getChild("name").setText(player.getName());
				
				Element scores = xmlInstance.getChild("score");
				
				scores.getChild("moeda").setText(String.valueOf(player.getMoedas()));
				scores.getChild("estrela").setText(String.valueOf(player.getEstrelas()));
				scores.getChild("topico").setText(String.valueOf(player.getTopicos()));
				scores.getChild("comentario").setText(String.valueOf(player.getComentarios()));
				scores.getChild("curtida").setText(String.valueOf(player.getCurtidas()));
			}

			xml.persistXmlStruct();

		}

	public boolean delete(String playerName) throws IOException, JDOMException {
		
		Element xmlInstance = null;

		for(Element p : xml.getXmlStruct().getChild("players").getChildren()){
			if(p.getChildText("name").equals(playerName)){
				xmlInstance = p;
				break;
				}
			}

		if(xmlInstance.detach() == null){	
			return false;
		} else{
			xml.persistXmlStruct();
			return true;
		}
	}
	}
