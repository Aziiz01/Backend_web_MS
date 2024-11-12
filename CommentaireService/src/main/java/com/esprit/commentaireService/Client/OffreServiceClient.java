package com.esprit.commentaireService.Client;
@FeignClient(name = "offre-service")
public interface OffreServiceClient {

    @GetMapping("/api/offers/{offerId}/comments")
    List<Comment> getCommentsByOfferId(@PathVariable("offerId") Long offerId);
}
