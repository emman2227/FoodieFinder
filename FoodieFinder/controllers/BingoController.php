<?php

require_once './models/bingo.php';

class BingoController {
    private $db;

    public function __construct($db) {
        $this->db = $db;
    }
}

?>