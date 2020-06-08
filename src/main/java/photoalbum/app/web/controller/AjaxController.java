package photoalbum.app.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;

import photoalbum.app.data.ProfileStorage;
import photoalbum.app.data.RelationshipsStorage;
import photoalbum.app.spring.ProfileDetailsImpl;

@RestController
@RequestMapping("/ajax")
public class AjaxController {
	@Autowired
	RelationshipsStorage relationshipsStorage;
	
	@Autowired
	ProfileStorage profileStorage;
	
	@RequestMapping(value = "/add-friend")
	public void addFriend(@RequestParam("n") String nick) {
		ProfileDetailsImpl profileDetails = (ProfileDetailsImpl)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		relationshipsStorage.sendInvite(profileStorage.getIdByNickname(profileDetails.getNickname()), profileStorage.getIdByNickname(nick));
	}
	
	@RequestMapping(value = "/add-friend-button") //, produces = MediaType.APPLICATION_JSON_VALUE
	public boolean showAddFriendButton(@RequestParam("n") String nick) {
		ProfileDetailsImpl profileDetails = (ProfileDetailsImpl)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(profileDetails.getNickname().equals(nick))	
			return false;
		else
			return true;
	}
}