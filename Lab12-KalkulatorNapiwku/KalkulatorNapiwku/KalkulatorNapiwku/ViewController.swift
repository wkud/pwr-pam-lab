//
//  ViewController.swift
//  KalkulatorNapiwku
//
//  Created by Student33 on 11/01/2022.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var result: UILabel!
    @IBOutlet weak var tipMultSlider: UISlider!
    @IBOutlet weak var tipBaseVallue: UITextField!
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }

    @IBAction func onClick(_ sender: Any) {
        var baseValue = Float(tipBaseVallue.text ?? "0") ?? 0;
        var value = tipMultSlider.value * baseValue;
        result.text = "Your tip: " + String(value);
    }
    
}

