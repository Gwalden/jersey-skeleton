define(["jquery"],  function(require) {
    return function Events(game) {
        this.game = game;

        /**
         * Appel� lorsque le joueur arrive sur une nouvelle cellule
         * cellId : Id de la cellule
         */
        this.onPlayerArrivalOn = function(cellId) {
            console.log(cellId);

            // Si c'est la cellule d'arriv�e
            if (cellId == 3) {
                alert("Bravo ! Vous avez r�ussi le niveau !\n\nVous allez �tre redirig� vers le niveau suivant.");
                // Faire la redirection
            }
        }
    }
});