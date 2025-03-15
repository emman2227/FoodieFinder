<?php

class Bingo {
    private $db;

    public $id;
    public $shop_id;
    public $item1;
    public $item2;
    public $item3;
    public $item4;
    public $item5;
    public $item6;
    public $item7;
    public $item8;
    public $item9;

    public function __construct($db) {
        $this->db = $db;
    }

    
}

?>