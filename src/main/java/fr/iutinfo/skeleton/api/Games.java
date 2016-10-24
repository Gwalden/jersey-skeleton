package fr.iutinfo.skeleton.api;

import java.util.List;
import java.util.ArrayList;

import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;

@Path("/games")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class Games {

	private static List<Game>glist = new ArrayList<>();
	private static List<User>ulist = new ArrayList<>();
	
	
	@GET
	public Game getGame(@Context SecurityContext context){
		User u = (User) context.getUserPrincipal();
		for (Game lgame : glist) {
			if (lgame.getPlayer1().getName() == u.getName() || lgame.getPlayer2().getName() == u.getName())
				return lgame;
		}
		throw new WebApplicationException(404);
	}
	
	
	@POST
	public void creatGame(@Context SecurityContext context){
		User u = (User) context.getUserPrincipal();
		ulist.add(u);
		if (ulist.size() > 2){
			Game gamec = new Game();
			gamec.setPlayer1(ulist.get(0));
			gamec.setPlayer2(ulist.get(1));
			ulist.remove(0);
			ulist.remove(1);
			glist.add(gamec);
		}
	}
	
	@PUT
	public Game playGame(@Context SecurityContext context){
		User u = (User) context.getUserPrincipal();
		Game g = null;
		for (Game lgame : glist) {
			if (lgame.getPlayer1().getName() == u.getName() || lgame.getPlayer2().getName() == u.getName())
				g=lgame;
		}
		return g;
	}
}
