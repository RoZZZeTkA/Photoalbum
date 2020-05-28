package photoalbum.app.domain.album;

import java.util.List;

import photoalbum.app.domain.model.AccesLevel;
import photoalbum.app.domain.model.Album;

public interface AlbumService {
	
	List<Album> getAlbumListByUser(Long profileId);
	void insertAlbum(Long profileId, String albumName, int numberOfPhotos, AccesLevel accesLevel);
	void updateAlbum(Long id, Long profileId, String albumName, int numberOfPhotos, AccesLevel accesLevel);
	void deleteAlbum(Long id);
}
