function R = recall(class, predictions, truth)
    predictions = string(predictions);
    truth = string(truth);

    true_positives = sum(strcmp(predictions, class) & strcmp(truth, class));
    false_negatives = sum(~strcmp(predictions, class) & strcmp(truth, class));

    R = true_positives / (true_positives + false_negatives) * 100;

end