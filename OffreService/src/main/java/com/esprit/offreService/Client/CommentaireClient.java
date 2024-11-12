package com.esprit.offreService.Client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.ResponseEntity;
import com.esprit.offreService.dto.CommentaireDTO;
import java.util.List;  // Add this import

@FeignClient(name = "COMMENTAIRESERVICE")
public interface CommentaireClient {

    @GetMapping("/api/commentaires/offer/{offerId}")
    List<CommentaireDTO> getCommentairesByOfferId(@PathVariable("offerId") Long offerId);
}
