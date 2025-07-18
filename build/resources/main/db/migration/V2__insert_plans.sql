SET search_path TO umihiro;

INSERT INTO plans (name, price, streaming_quality, description)
SELECT 'None',    0.00, 'NONE', 'No plan selected'
    WHERE NOT EXISTS (SELECT 1 FROM plans WHERE name = 'None');

INSERT INTO plans (name, price, streaming_quality, description)
SELECT 'Basic',   5.00, 'HD',   'Basic plan with HD streaming quality'
    WHERE NOT EXISTS (SELECT 1 FROM plans WHERE name = 'Basic');

INSERT INTO plans (name, price, streaming_quality, description)
SELECT 'Standard',10.00, 'FHD',  'Standard plan with FHD streaming quality'
    WHERE NOT EXISTS (SELECT 1 FROM plans WHERE name = 'Standard');

INSERT INTO plans (name, price, streaming_quality, description)
SELECT 'Premium',20.00, 'UHD',  'Premium plan with UHD streaming quality'
    WHERE NOT EXISTS (SELECT 1 FROM plans WHERE name = 'Premium');