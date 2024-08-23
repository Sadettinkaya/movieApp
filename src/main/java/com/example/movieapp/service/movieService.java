package com.example.movieapp.service;

import com.example.movieapp.dto.requestDto.movieSaveDto;
import com.example.movieapp.dto.responseDto.movieByYonetmenResponseDto;
import com.example.movieapp.entity.Movie;
import com.example.movieapp.entity.Yonetmen;
import com.example.movieapp.repository.movieRepository;
import com.example.movieapp.repository.yonetmenRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class movieService {

    private final movieRepository movierepository;
    private final yonetmenRepository yonetmenrepository;
    private final ModelMapper modelMapper;

    //amac requestdto vermek bunu filmdto içindeki fieldlara göre kaydetmek
    //film kaydederken yonetmenıd yi de kaydettim  movie entitiysinde yonetmen nesnesi oldugu için
    //dto ile uyuşmayınca direkt modelmapper kullanamadım requestdto yu entitye çevirip o şekilde veritabanına kaydettim
    public Boolean saveMovie(movieSaveDto moviesavedto) {
       String filmadi= moviesavedto.getFilm_adi();
       int imdb=moviesavedto.getImdb();
       Long yonetmenid= moviesavedto.getYonetmen_id();

       Yonetmen yonetmen= yonetmenrepository.findById(yonetmenid).get();
       Movie movie = Movie.builder().film_adi(filmadi).imdb(imdb).yonetmen(yonetmen).build();
       movierepository.save(movie); //entity kaydeder o yüzden dtodan entitye çevirdik
       return true;
    }



    //liste halinde bir responsedto donecek amac movie nin içindeki yönetmenid ye göre filmleri çekmek
    public List<movieByYonetmenResponseDto > findAllMovieByYonetmenId(Long yonetmenId) {
        Yonetmen yonetmen= yonetmenrepository.findById(yonetmenId).get();
        List<Movie>MovieList = movierepository.findAllByYonetmenId(yonetmenId);
        List<movieByYonetmenResponseDto > movielistyonetmen= new ArrayList<>();
        for(Movie movie:MovieList){
            String yonetmen_adi= movie.getYonetmen().getYonetmen_adi();
            String film_adi= movie.getFilm_adi();
            int imdb= movie.getImdb();
            movieByYonetmenResponseDto movieByYonetmenResponsedto = new movieByYonetmenResponseDto();
            movieByYonetmenResponsedto.setFilm_adi(film_adi);
            movieByYonetmenResponsedto.setImdb(imdb);
            movieByYonetmenResponsedto.setYonetmen_adi(yonetmen.getYonetmen_adi());;
            movielistyonetmen.add(movieByYonetmenResponsedto);
        }

        return  movielistyonetmen;
    }

    public Boolean deleteMovieId(Long movieId) {
         movierepository.deleteById(movieId);
         return true;
    }
}
