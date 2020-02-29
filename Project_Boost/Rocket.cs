using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;

public class Rocket : MonoBehaviour {
    private bool groundcheck;
    private int sceneIndex; 
    Rigidbody rigidBody;
    AudioSource audioSource;
    [SerializeField] float rotateAngle = 50f;
    [SerializeField] float mainThrust = 100f;
    [SerializeField] AudioClip mainEngine;
    [SerializeField] AudioClip explosion;
    [SerializeField] AudioClip win;

    [SerializeField] ParticleSystem thrustEffect;
    [SerializeField] ParticleSystem explodeEffect;
    [SerializeField] ParticleSystem winEffect;

    enum State { Alive,Dead,Transending};
    State state = State.Alive;
	void Start () {
        rigidBody = GetComponent<Rigidbody>();
        audioSource = GetComponent<AudioSource>();
	}
	
	// Update is called once per frame
	void Update () {
        Thrust();
        Rotate();
	}
    private void OnCollisionEnter(Collision collision)
    {
        if (state != State.Alive)
        {
            return;
        }
        switch (collision.gameObject.tag)
        {
            case "friendly":
                groundcheck = true;
                print("friendly collide");
                break;
            case "obstacle":
                audioSource.Stop();
                audioSource.PlayOneShot(explosion);
                explodeEffect.Play();
                state = State.Dead;
                Invoke("Die", 3f);
                break;
            case "finish":
                audioSource.PlayOneShot(win);
                winEffect.Play();
                state = State.Transending;
                Invoke("LoadNextScene", 2f);
                //sceneIndex += 1;
                break;
        }
    }

    private void LoadNextScene()
    {
        int currentScene = SceneManager.GetActiveScene().buildIndex;
        int nextScene = currentScene + 1;
        if(nextScene > SceneManager.sceneCountInBuildSettings-1)
        {
            SceneManager.LoadScene(0);
            state = State.Alive;
        } else
            SceneManager.LoadScene(nextScene);
            state = State.Alive;
    }

    private void Rotate()
    {
        if (state == State.Alive)
        {
            float shipRotate;
            shipRotate = rotateAngle * Time.deltaTime;
            rigidBody.freezeRotation = true;
            if (Input.GetKey(KeyCode.D))
            {
                if (groundcheck == false)
                {
                    transform.Rotate(new Vector3(0, 0, -shipRotate));
                }
            }
            if (Input.GetKey(KeyCode.A))
            {
                if (groundcheck == false)
                {
                    transform.Rotate(new Vector3(0, 0, shipRotate));
                }
            }
            rigidBody.freezeRotation = false;
        }
        else
            print("waiting");
    }
    private void Thrust()
    {
        if (state == State.Alive)
        {
            float shipThrust;
            shipThrust = mainThrust * Time.deltaTime;
            if (Input.GetKey(KeyCode.Space))
            {
                groundcheck = false;
                rigidBody.AddRelativeForce(Vector3.up * shipThrust);
                if (!audioSource.isPlaying)
                {
                    audioSource.PlayOneShot(mainEngine);
                }
                thrustEffect.Play();
            }
            else {
                audioSource.Stop();
                thrustEffect.Stop();
            }
        }
        else
            print("waiting");
    }
    private void Die()
    {
        //  transform.position = new Vector3(0, 16.5f, 0);
        // transform.rotation = Quaternion.identity;
        //  mainThrust = 0;
        sceneIndex = 0;
        SceneManager.LoadScene(0);
        state = State.Alive;
    }
}
